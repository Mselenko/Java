package task_2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ButtonMethods {

	final int FNAME = 20;
	final int LNAME = 20;
	final int CITY = 20;
	final int PROVINCE = 4;
	final int POSTAL = 5;
	protected int id = 1;
	NewPanel pane;
	RandomAccessFile file;

	public ButtonMethods(NewPanel pane) throws FileNotFoundException {
		this.pane = pane;
		this.file = new RandomAccessFile("AddressBook.dat", "rw");
	}

	public void add() throws IOException {
		file.seek(file.length());
		write(file);
		id++;
	}

	public void first() throws IOException {
		if (file.length() > 0) {
			file.seek(0);
			read(file);
			System.out.println("Reading address 1");
			id = 1;
		} else {
			System.out.println("Address is empty!");
		}
	}

	public void next() throws IOException {
		if (id * 69 < file.length()) {
			file.seek(id * 69);
			read(file);
			id++;
			System.out.println("Reading address " + id);
		} else {
			System.out.println("End of file!");
		}
	}

	public void previous() throws IOException {
		if (id > 1)
			id--;
		else
			id = 1;
		file.seek((id * 69) - 69);
		read(file);
		System.out.println("Reading address " + id);
	}

	public void last() throws IOException {

		id = ((int) file.length()) / 69;
		file.seek((id * 69) - 69);
		read(file);
		System.out.println("Reading address " + id);

	}

	public void update() throws IOException {

		file.seek((id * 69) - 69);
		write(file);

	}

	private void write(RandomAccessFile file) throws IOException {
		if (this.check()) {
			file.write(fixedLength(pane.firstName.getText().getBytes(), FNAME));
			file.write(fixedLength(pane.lastName.getText().getBytes(), LNAME));
			file.write(fixedLength(pane.city.getText().getBytes(), CITY));
			file.write(fixedLength(pane.province.getValue().getBytes(), PROVINCE));
			file.write(fixedLength(pane.postalCode.getText().getBytes(), POSTAL));
			System.out.println("Address " + id + " saved!");
		} else {
			System.out.println("Name and City should not contain numbers and Postal code should be 5 digits length");
			id--;
		}

	}

	private byte[] fixedLength(byte[] x, int n) {
		byte[] b = new byte[n];
		for (int i = 0; i < x.length; i++) {
			b[i] = x[i];
		}
		return b;
	}

	private void read(RandomAccessFile file) throws IOException {

		int pos;

		byte[] fname = new byte[FNAME];
		pos = file.read(fname);
		pane.firstName.setText(new String(fname));

		byte[] lname = new byte[FNAME];
		pos += file.read(lname);
		pane.lastName.setText(new String(lname));

		byte[] city = new byte[CITY];
		pos += file.read(city);
		pane.city.setText(new String(city));

		byte[] province = new byte[PROVINCE];
		pos += file.read(province);
		pane.province.setValue(new String(province));

		byte[] postal = new byte[POSTAL];
		pos += file.read(postal);
		pane.postalCode.setText(new String(postal));

	}

	private boolean check() {
		if (pane.firstName.getText().matches(".*\\d.*") || pane.lastName.getText().matches(".*\\d.*")
				|| pane.city.getText().matches(".*\\d.*") || pane.postalCode.getText().length() != 5)
			return false;
		else
			return true;
	}

}