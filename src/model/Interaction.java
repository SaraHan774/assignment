package model;

public class Interaction {

    private String id;
    private String dateOfInteraction;
    private Customer customer;
    private String interactionMethod;
    private String potential;

    public Interaction(){

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDateOfInteraction(String dateOfInteraction) {
        this.dateOfInteraction = dateOfInteraction;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setInteractionMethod(String interactionMethod) {
        this.interactionMethod = interactionMethod;
    }

    public void setPotential(String potential) {
        this.potential = potential;
    }

    public String getId() {
        return id;
    }

    public String getDateOfInteraction() {
        return dateOfInteraction;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getInteractionMethod() {
        return interactionMethod;
    }

    public String getPotential() {
        return potential;
    }

    @Override
    public String toString() {
        return id +", " + dateOfInteraction + ", " + customer.getId() + ", " + interactionMethod + ", "
                + potential;
    }
}
