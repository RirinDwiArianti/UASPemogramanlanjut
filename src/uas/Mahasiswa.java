package uas;

public class Mahasiswa implements Comparable<Mahasiswa> {
	protected String name;

	public Mahasiswa() {
	}

	public Mahasiswa(String name) {
		setName(name);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException();
		}

		this.name = name;
	}

	public String toString() {
		return this.name;
	}

	public int compareTo(Mahasiswa another) {
		return this.name.compareTo(another.getName());
	}

	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj instanceof Mahasiswa) {
			Mahasiswa another = (Mahasiswa) obj;
			if (this.name.equals(another.getName())) {
				return true;
			}
		}

		return false;
	}

	public int hashCode() {
		return this.name.hashCode();
	}
}