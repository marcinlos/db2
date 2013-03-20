package org.hibernate.tutorial;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.domain.Person;
import org.hibernate.tutorial.util.HibernateUtil;

public class EventManager {
	public static void main(String[] args) {
		EventManager mgr = new EventManager();
		if (args[0].equals("store")) {
			mgr.createAndStoreEvent("MyEvent", new Date());
		} else if (args[0].equals("list")) {
			List<Event> events = mgr.listEvents();
			for (Event theEvent: events) {
				System.out.println("Event: " + theEvent.getTitle() + 
						" [" + theEvent.getDate() + "]");
			}
		} else if (args[0].equals("addpersontoevent")) {
			Long eventId = mgr.createAndStoreEvent("My event", new Date());
			Long personId = mgr.createAndStorePerson("Foo", "Bar");
			mgr.addPersonToEvent(personId, eventId);
			System.out.println("Added person " + personId + " to event " + eventId);
		}
		HibernateUtil.getSessionFactory().close();
	}

	private Long createAndStoreEvent(String title, Date theDate) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Event theEvent = new Event();
		theEvent.setTitle(title);
		theEvent.setDate(theDate);
		Long id = (Long) session.save(theEvent);
		
		session.getTransaction().commit();
		return id;
	}
	
	private Long createAndStorePerson(String firstname, String lastname) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Person person = new Person();
		person.setFirstname(firstname);
		person.setLastname(lastname);
		Long id = (Long) session.save(person);
		
		session.getTransaction().commit();
		return id;
	}
	
	private List<Event> listEvents() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Event> results = session.createQuery("from Event").list();
		session.getTransaction().commit();
		return results;
	}
	
	private void addPersonToEvent(Long personId, Long eventId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Person aPerson = (Person) session
			.createQuery("select p from Person p left join fetch p.events " + 
					"where p.id = :pid")
			.setParameter("pid", personId)
			.uniqueResult();
		Event anEvent = (Event) session.load(Event.class, eventId);
		session.getTransaction().commit();
		
		aPerson.getEvents().add(anEvent);
		
		Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
		session2.beginTransaction();
		session2.update(aPerson);
		
		session2.getTransaction().commit();
	}
	
}
