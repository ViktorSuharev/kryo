package kryo;

//do not change code below
public class Address {
    private String street;
    private String city;
    private String country;

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return this.street.equals(address.street)
                && this.city.equals(address.city) && this.country.equals(address.country);
    }

    @Override
    public String toString() {
        return this.street + ", " + this.city + ", " +
                this.country;
    }
}
