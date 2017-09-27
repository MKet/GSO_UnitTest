package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marco Ketelaars
 */
public class Appointment {

    private ArrayList<Contact> agenda;
    private String subject;
    private TimeSpan span;

    /**
     * Constructs appointment object with following parameters
     * @param subject subject of the appointment
     * @param span timeSpan of the appointment
     */
    public Appointment(String subject, TimeSpan span) {
        this.subject = subject;
        this.span = span;

        agenda = new ArrayList<>();
    }

    /**
     * adds a contact to the appointment
     *
     * fails if addition would result in a conflict in the contacts agenda
     * @param contact the invited contact
     * @return Whether addition of contact succeeded
     */
    public boolean addContact(Contact contact) {
        if (!agenda.contains(contact))
            return false;
        for (Contact con : agenda) {
            Iterator<Appointment> iterator =  con.appointments();
            Appointment point;
            while (iterator.hasNext()) {
                point = iterator.next();

                if (point.span.isPartOf(span))
                    return false;
            }
        }
        agenda.add(contact);
        return true;
    }

    /**
     * removes a contact from the appointment
     *
     * @param contact the contact that is to be removed
     */
    public void removeContact(Contact contact) {
        throw new UnsupportedOperationException();
    }

    /**
     * gets iterator of invitees
     * @return iterator of invitees
     */
    public Iterator<Contact> invitees() {
        throw new UnsupportedOperationException();
    }

    /**
     * gets subject of this appointment
     * @return subject of this appointment
     */
    public String getSubject() {
        throw new UnsupportedOperationException();
    }

    /**
     * gets the time the appointment takes place
     * @return timSpan
     */
    public ITimeSpan getTimeSpan() {
        throw new UnsupportedOperationException();
    }
}
