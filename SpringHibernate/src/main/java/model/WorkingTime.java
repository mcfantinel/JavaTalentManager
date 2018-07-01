package model;

public enum WorkingTime {

	FULL_TIME {
		public String toString() {
			return "Full Time";
		}
	},

	PART_TIME {
		public String toString() {
			return "Part Time";
		}
	},
	
	BOTH {
		public String toString() {
			return "Both";
		}
	}

}
