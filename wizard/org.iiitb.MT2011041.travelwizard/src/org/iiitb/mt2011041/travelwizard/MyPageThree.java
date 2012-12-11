package org.iiitb.mt2011041.travelwizard;

import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

public class MyPageThree extends WizardPage {
	private Text text1;
	private Composite container;

	public MyPageThree() {
		super("Third Page");
		setTitle("Third Page");
		setDescription("Third page of Travel Information Wizard");
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		
		Label label1 = new Label(container, SWT.NULL);
		label1.setText("Select Agent type");

		text1 = new Text(container, SWT.BORDER | SWT.SINGLE);
		text1.setText("");
		text1.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (!text1.getText().isEmpty()) {
					setPageComplete(true);

				}
			}

		});
		
		ListViewer list = new ListViewer(container, SWT.MULTI |  SWT.V_SCROLL);
		Text text = new Text(container,  SWT.BORDER);
		
		String[] agents = new String[]{"ABC", "DEF", "GHI", "JKL","MNO","PQR"};
		  
		for(int i=0; i<agents.length; i++)
		  list.add(agents[i]);
		
		Label label2 = new Label(container, SWT.NULL);
		label2.setText("Select Date:");
		
		DateTime dateD = new DateTime(container, SWT.DATE | SWT.DROP_DOWN);
		
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		text1.setLayoutData(gd);
		// Required to avoid an error in the system
		setControl(container);
		setPageComplete(false);

	}

	public String getText1() {
		return text1.getText();
	}
}
