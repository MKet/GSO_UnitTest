package fontys.time;

import java.util.List;

/**
 * @author Marco Ketelaars
 */
public class Appointment {

    /**
     * Constructs appointment object with following parameters
     * @param subject subject of the appointment
     * @param span timeSpan of the appointment
     * @param contacts the contacts that are invited to this appointment
     */
    public Appointment(String subject, TimeSpan span, List<Contact> contacts) { }

    /**
     * adds a contact to the appointment
     *
     * fails if addition would result in a conflict in the contacts agenda
     * @param contact the invited contact
     */
    public void addContact(Contact contact) {
        throw new UnsupportedOperationException();
    }

    /**
     * removes a contact from the appointment
     *
     * @param contact the contact that is to be removed
     */
    public void removeContact(Contact contact) {
        throw new UnsupportedOperationException();
    }
}
