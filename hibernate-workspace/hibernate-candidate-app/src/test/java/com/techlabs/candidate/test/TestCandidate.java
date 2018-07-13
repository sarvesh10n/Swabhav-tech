package com.techlabs.candidate.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import antlr.collections.List;

import com.techlabs.candidate.Candidate;

public class TestCandidate {

	static Transaction txn = null;
	static Session session = null;

	public static void main(String args[]) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");

		SessionFactory factory = config.buildSessionFactory();
		System.out.println(factory.getClass());

		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			// Candidate cand=new Candidate();
			// cand.setName("atharv");
			//
			// session.save(cand);
			// System.out.println(cand.getCandidate_id().toString());
			UUID id = UUID.fromString("0b9684f8-6c56-4226-bc72-6d7c28277c1a");
			displayCandidate();
			updateCandidate(id);
			deleteCandidate();

			txn.commit();
		} catch (HibernateException e) {
			System.out.println(e);
			txn.rollback();
		} finally {
			session.close();
		}
	}

	public static void updateCandidate(UUID id) {
		Candidate c = (Candidate) session.get(Candidate.class, id);
		c.setName("santosh");
		session.save(c);
	}

	public static void displayCandidate() {
		ArrayList<Candidate> candidates = new ArrayList<>();
		candidates = (ArrayList<Candidate>) session.createQuery(
				"FROM Candidate").list();
		for (Candidate c : candidates) {
			System.out.println(c.getCandidate_id());
			System.out.println(c.getName());
		}
	}

	public static void deleteCandidate() {
		
		Candidate c = (Candidate) session.get(Candidate.class,
				UUID.fromString("bc376886-096d-4470-91e3-61d773819459"));
		session.delete(c);
	}
}
