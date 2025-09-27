import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Race {
    private Car leader;
    private Integer time = 24;

    private Map<Car, Integer> participantsResults;

    public Race() {
        this.participantsResults = new HashMap<>();
    }

    public void defineLeader() {
        Optional<Map.Entry<Car, Integer>> maxEntry = participantsResults.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        if (maxEntry.isPresent()) {
            this.leader = maxEntry.get().getKey();
        } else {
            System.out.println("Машины не заведены");
        }
    }

    public void addParticipant(Car car) {
        participantsResults.put(car, car.getSpeed() * time);
    }

    public Integer getTime() {
            return this.time;
    }

    public void setTime(Integer time) {
            this.time = time;
    }

    public Set<Car> getParticipants() {
            return participantsResults.keySet();
    }

    public void setParticipants(HashSet<Car> participants) {
        if (participants.isEmpty()) {
            return;
        }
        for (Car participant: participants) {
            participantsResults.put(participant, participant.getSpeed() * time);
        }
    }

    @Override
    public String toString() {
            return String.format("Самая быстрая машина: %s", this.leader.getName());
    }
}
