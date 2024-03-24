package chapter2.item5.database.model;

public class Customer {
	private String email;
	private String firstName;
	private String lastName;
	private String company;
	private String createdAt;
	private String country;

	private Customer(Builder builder) {
		this.email = builder.email;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.company = builder.company;
		this.createdAt = builder.createdAt;
		this.country = builder.country;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCompany() {
		return company;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getCountry() {
		return country;
	}

	public static class Builder {
		private String email;
		private String firstName;
		private String lastName;
		private String company;
		private String createdAt;
		private String country;

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder company(String company) {
			this.company = company;
			return this;
		}

		public Builder createdAt(String createdAt) {
			this.createdAt = createdAt;
			return this;
		}

		public Builder country(String country) {
			this.country = country;
			return this;
		}

		public Customer build() {
			return new Customer(this);
		}
	}
}
