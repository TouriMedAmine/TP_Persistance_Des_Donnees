package persistance;

public class Vehicule {
	
		private int id;
		private String code_interne;
		private String immatriculation;
		private String dateMiseEnCirculation;
		@Override
		public String toString() {
			return "Vehicule [id=" + id + ", code_interne=" + code_interne + ", immatriculation=" + immatriculation
					+ ", dateMiseEnCirculation=" + dateMiseEnCirculation + "]";
		}
		public Vehicule(int id, String code_interne, String immatriculation, String dateMiseEncirculation) {
			super();
			this.id = id;
			this.code_interne = code_interne;
			this.immatriculation = immatriculation;
			this.dateMiseEnCirculation = dateMiseEnCirculation;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCode_interne() {
			return code_interne;
		}
		public void setCode_interne(String code_interne) {
			this.code_interne = code_interne;
		}
		public String getImmatriculation() {
			return immatriculation;
		}
		public void setImmatriculation(String immatriculation) {
			this.immatriculation = immatriculation;
		}
		public String getDateMiseEnCirculation() {
			return dateMiseEnCirculation;
		}
		public void setDateMiseEnCirculation(String dateMiseEncirculation) {
		this.dateMiseEnCirculation = dateMiseEnCirculation;
	}

}

