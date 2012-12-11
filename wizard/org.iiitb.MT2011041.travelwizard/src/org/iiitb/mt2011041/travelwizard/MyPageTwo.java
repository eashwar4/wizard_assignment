package org.iiitb.mt2011041.travelwizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class MyPageTwo extends WizardPage {
	private Text text1;
	private Text text2;
	private Text text3;
	private Text text4;
	private Text text5;

	private Composite container;

	public MyPageTwo() {
		super("Second Page");
		setTitle("Second Page");
		setDescription("Second page of Travel Information Wizard");
		setControl(text1);
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		Label label1 = new Label(container, SWT.NULL);
		label1.setText("Enter From Station");

		text1 = new Text(container, SWT.BORDER | SWT.SINGLE);
		text1.setText("");

		text1.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (!text1.getText().isEmpty()) {
					setPageComplete(true);
				}
			}

		});

		Label label2 = new Label(container, SWT.NULL);
		label2.setText("Enter To Station");

		text2 = new Text(container, SWT.BORDER | SWT.SINGLE);
		text2.setText("");

		Label label3 = new Label(container, SWT.NULL);
		label3.setText("VIA");

		text3 = new Text(container, SWT.BORDER | SWT.SINGLE);
		text3.setText("");

		Label label4 = new Label(container, SWT.NULL);
		label4.setText("VIA");

		text4 = new Text(container, SWT.BORDER | SWT.SINGLE);
		text4.setText("");

		Label label5 = new Label(container, SWT.NULL);
		label5.setText("VIA");

		text5 = new Text(container, SWT.BORDER | SWT.SINGLE);
		text5.setText("");

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		text1.setLayoutData(gd);

		// Required to avoid an error in the system
		setControl(container);
		setPageComplete(false);
	}

	public String getText1() {
		return text1.getText();
	}

	public String getText2() {
		return text2.getText();
	}

	public String getText3() {
		return text3.getText();
	}

	public String getText4() {
		return text4.getText();
	}

	public String getText5() {
		return text5.getText();
	}
}