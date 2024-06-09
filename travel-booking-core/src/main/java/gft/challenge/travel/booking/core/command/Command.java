package gft.challenge.travel.booking.core.command;

public interface Command<R> {
    R process(final Context context);
}
