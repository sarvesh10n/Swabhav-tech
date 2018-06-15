
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		DateTimeFormatter dtf = DateTimeFormatter
				.ofPattern("yyyy/MM/dd HH:mm:ss");

		JButton btnPrint = new JButton("print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				while (true) {
					LocalDateTime now = LocalDateTime.now();
					System.out.println(dtf.format(now));
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnPrint.setBounds(24, 48, 97, 49);
		frame.getContentPane().add(btnPrint);

		JButton btnPrintAsync = new JButton("print async");
		btnPrintAsync.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread t1=new Thread(new PrintThread());
				t1.start();
				
			}
		});
		btnPrintAsync.setBounds(160, 48, 97, 49);
		frame.getContentPane().add(btnPrintAsync);

		JButton btnHello = new JButton("hello");
		btnHello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");
			}
		});
		btnHello.setBounds(296, 48, 97, 49);
		frame.getContentPane().add(btnHello);
	}
}
