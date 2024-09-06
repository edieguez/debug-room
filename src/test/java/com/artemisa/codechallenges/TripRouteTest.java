package com.artemisa.codechallenges;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripRouteTest {

    @Test
    void ticketChallengeTest() {
        assertEquals("[B, D, C, E, A]", getTripRoute(Arrays.asList("E,A", "B,D", "C,E", "D,C")).toString());
        assertEquals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]",
                getTripRoute(Arrays.asList("C,D", "D,E", "E,F", "F,G", "G,H", "H,I", "I,J", "J,K", "K,L", "L,M", "M,N", "N,O", "O,P", "P,Q", "Q,R", "R,S", "S,T", "T,U", "U,V", "V,W", "W,X", "X,Y", "Y,Z", "A,B", "B,C")).toString());
    }

    private List<String> getTripRoute(List<String> tickets) {
        List<String> trip = new ArrayList<>();
        Map<String, String> originDestinationMap = new HashMap<>();

        for (String ticket : tickets) {
            String origin = ticket.split(",")[0];
            String destination = ticket.split(",")[1];

            originDestinationMap.put(origin, destination);
        }

        String currentCity = getInitialCity(originDestinationMap);

        while (originDestinationMap.containsKey(currentCity)) {
            trip.add(currentCity);
            currentCity = originDestinationMap.get(currentCity);
        }

        trip.add(currentCity);

        return trip;
    }

    private String getInitialCity(Map<String, String> originDestinationMap) {
        Set<Map.Entry<String, String>> origins = originDestinationMap.entrySet();
        Set<String> destinations = new HashSet<>(originDestinationMap.values());

        origins.removeAll(destinations);

        return origins.iterator().next().getKey();
    }
}
