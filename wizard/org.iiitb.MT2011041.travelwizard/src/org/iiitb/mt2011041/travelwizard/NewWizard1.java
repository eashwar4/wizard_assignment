package org.iiitb.mt2011041.travelwizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

import org.iiitb.mt2011041.travelwizard.*;

public class NewWizard1 extends Wizard implements INewWizard {

	protected MyPageOne one;
	protected MyPageTwo two;
	protected MyPageThree three;

	private DBconn dbconn = null;
	private Connection con = null;
	private PreparedStatement pst = null;
	private Statement stmt = null;
	private ResultSet resultSet = null;
	private String query1 = null;

	public NewWizard1() {
		super();
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		one = new MyPageOne();
		two = new MyPageTwo();
		three = new MyPageThree();

		addPage(one);
		addPage(two);
		addPage(three);
	}

	@Override
	public boolean performFinish() {
		// Print the result to the console
		System.out.println(one.getText1());
		System.out.println(two.getText1());
		System.out.println(three.getText1());

		// adding JDBC connectivity now
		
		try {

			// to insert details into user credentials table

			dbconn = new DBconn();
			con = dbconn.getConnection();

			String query1 = "INSERT INTO travel_info(name, from, to, via1, via2, via3) VALUES(?,?,?,?,?,?)";

			pst = con.prepareStatement(query1);
			pst.setString(1, one.getText1());
			pst.setString(2, two.getText1());
			pst.setString(3, two.getText2());
			pst.setString(4, two.getText3());
			pst.setString(5, two.getText4());
			pst.setString(6, two.getText5());
			
			pst.executeUpdate();

			System.out.println("query is:"+pst);

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		finally {
			dbconn.close(resultSet);
			dbconn.close(pst);
			dbconn.close(con);
		}

		return true;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}
}