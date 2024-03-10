package lab3.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.UIManager;

public class Team {
    private ArrayList<Avenger> avengers;

    public Team() {
        avengers = new ArrayList<Avenger>();
    }

    public void loadAvengers(Context context) {
        UIManager assetManager = ((Object) context).getAssets();
        InputStream inputStream = null;
        try {
            inputStream = assetManager.open("data.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                String alias = parts[1];
                String gender = parts[2];
                int heightFeet = Integer.parseInt(parts[3]);
                int heightInches = Integer.parseInt(parts[4]);
                int weight = Integer.parseInt(parts[5]);
                String powers = parts[6];
                String location = parts[7];
                boolean hasPowers = (powers.trim().length() > 0);
                avengers.add(new Avenger(name, heightFeet, heightInches, weight, alias, location, hasPowers));
            }
        } catch (IOException e) {
            Log.e("Team", "Error loading Avengers: " + e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.e("Team", "Error closing InputStream: " + e.getMessage());
                }
            }
        }
    }

    public Avenger getAvenger(String alias) {
        for (Avenger avenger : avengers) {
            if (avenger.getAlias().equals(alias)) {
                return avenger;
            }
        }
        return null;
    }
}