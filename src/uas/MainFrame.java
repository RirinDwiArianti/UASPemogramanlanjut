package uas;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MainFrame extends JFrame {
	protected CustomListModel<Mahasiswa> listModel;
	protected java.util.List<Mahasiswa> mahasiswa = new ArrayList<>();


	private JButton buttonAdd;
	private JButton buttonSearch;
	private JList listMahasiswa;
	public JPanel rootpanel;
	private JButton buttonAscending;
	private JButton buttonDescending;
	private JButton hitungButton;
	private JTextField textFieldFaktorial;
	private JTextField textFieldHasil;
	private JButton hapusButton;

	public MainFrame() {

		listModel = new CustomListModel<Mahasiswa>(mahasiswa);
		listMahasiswa.setModel(listModel);
		listModel.addElement(new Mahasiswa("Ririn Dwi Arianti"));

		buttonAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addMahasiswa();
			}
		});
		buttonAscending.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ascendingSortMahasiswa();
			}
		});
		buttonDescending.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				descendingSortMahasiswa();
			}
		});
		buttonSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchMahasiswa();
			}
		});


		hitungButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n=Integer.parseInt(textFieldFaktorial.getText());
				int f=faktorial(n);
				String s= Integer.toString(f);
				textFieldHasil.setText(s);
			}
			private int faktorial(int n) {
				int f=1;
				for(
						int i=1;i<=n;i++) {
					f = f * i;
				}
				return f;
			}
			});
		hapusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldFaktorial.setText("");
				textFieldHasil.setText("");
			}
		});
	}


	private void addMahasiswa() {
		String mahasiswaName = JOptionPane.showInputDialog(this, "Masukkan nama mahasiswa");
		if (mahasiswaName != null) {
			listModel.addElement(new Mahasiswa(mahasiswaName));
		}
	}

	private void ascendingSortMahasiswa() {
		Collections.sort(mahasiswa);
		listModel.fireDataChanged();
	}
	private void descendingSortMahasiswa() {
		Collections.sort(mahasiswa,Collections.reverseOrder());
		listModel.fireDataChanged();
	}

	private void searchMahasiswa() {
		String mahasiswaName = JOptionPane.showInputDialog(this, "Masukkan nama mahasiswa yang anda cari:");

		if (mahasiswaName == null) {
			return;
		}


		int foundIndex = Collections.binarySearch(mahasiswa, new Mahasiswa(mahasiswaName));

		if (foundIndex >= 0) {
			listMahasiswa.setSelectedIndex(foundIndex);
		} else {
			JOptionPane.showMessageDialog(this, "Nama mahasiswa ini tidak ditemukan " + mahasiswaName);
		}
	}

}


