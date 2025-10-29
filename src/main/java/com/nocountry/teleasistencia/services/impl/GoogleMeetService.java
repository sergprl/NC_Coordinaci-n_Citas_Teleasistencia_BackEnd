package com.nocountry.teleasistencia.services.impl;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Collections;

@Service
public class GoogleMeetService {

    private static final String APPLICATION_NAME = "Meet Creator";
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final GsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    public String createMeetingLink(String summary, LocalDateTime startTime, int durationMinutes) {
//        try {
//            Calendar service = getCalendarService();
//
//            // Create event
//            Event event = new Event()
//                    .setSummary(summary)
//                    .setDescription("Meeting for customer");
//
//            // Set start time
//            EventDateTime start = new EventDateTime()
//                    .setDateTime(new com.google.api.client.util.DateTime(
//                            Date.from(startTime.atZone(ZoneId.systemDefault()).toInstant())))
//                    .setTimeZone("America/Mexico_City");
//            event.setStart(start);
//
//            // Set end time
//            LocalDateTime endTime = startTime.plusMinutes(durationMinutes);
//            EventDateTime end = new EventDateTime()
//                    .setDateTime(new com.google.api.client.util.DateTime(
//                            Date.from(endTime.atZone(ZoneId.systemDefault()).toInstant())))
//                    .setTimeZone("America/Mexico_City");
//            event.setEnd(end);
//
//            // Request Google Meet conference
//            ConferenceSolutionKey conferenceSolutionKey = new ConferenceSolutionKey()
//                    .setType("hangoutsMeet");
//            CreateConferenceRequest createConferenceRequest = new CreateConferenceRequest()
//                    .setRequestId(UUID.randomUUID().toString())
//                    .setConferenceSolutionKey(conferenceSolutionKey);
//
//            com.google.api.services.calendar.model.ConferenceData conferenceData =
//                    new com.google.api.services.calendar.model.ConferenceData()
//                            .setCreateRequest(createConferenceRequest);
//            event.setConferenceData(conferenceData);
//
//            // Insert event with conference
//            event = service.events().insert("primary", event)
//                    .setConferenceDataVersion(1)
//                    .setSendUpdates("none")
//                    .execute();
//
//            // Return Meet link
//            if (event.getConferenceData() != null &&
//                    event.getConferenceData().getEntryPoints() != null) {
//                return event.getConferenceData().getEntryPoints().get(0).getUri();
//            }
//
//            throw new RuntimeException("Failed to generate Meet link");
//
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to create Google Meet link: " + e.getMessage(), e);
//        }

        return "meetlinkexample.com";
    }

    private Calendar getCalendarService() throws Exception {
        // Load credentials.json
        InputStream in = getClass().getClassLoader()
                .getResourceAsStream("credentials.json");

        if (in == null) {
            throw new RuntimeException("credentials.json not found in resources");
        }

        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
                JSON_FACTORY,
                new InputStreamReader(in)
        );

        // Build authorization flow
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                clientSecrets,
                Collections.singletonList("https://www.googleapis.com/auth/calendar"))
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();

        // Authorize (first time will open browser)
        LocalServerReceiver receiver = new LocalServerReceiver.Builder()
                .setPort(8888)
                .build();

        Credential credential = new AuthorizationCodeInstalledApp(flow, receiver)
                .authorize("user");

        // Build and return Calendar service
        return new Calendar.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
}