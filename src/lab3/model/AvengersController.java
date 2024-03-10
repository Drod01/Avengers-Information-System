import java.awt.Button;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.View;

import org.w3c.dom.css.ViewCSS;

import lab3.model.Avenger;
import lab3.model.Person;
import lab3.model.Team;
public class AvengersController implements ViewCSS.OnClickListener {
private List<Button> buttons;
private Context context;
private Team team;

public AvengersController(Context context, List<Button> buttons) {
    this.context = context;
    this.buttons = buttons;
    team = new Team();
}

@Override
public void onClick(View v) {
    Button button = (Button) v;
    String alias = button.getText().toString();
    Avenger avenger = team.getAvenger(alias);

    if (avenger != null) {
        String location = getLocation(avenger);
        Toast.makeText(context, avenger.getName() + " is located at " + location, Toast.LENGTH_SHORT).show();
    } else {
        Toast.makeText(context, "Avenger not found", Toast.LENGTH_SHORT).show();
    }
}

private String getLocation(Avenger avenger) {
    String location = avenger.getLocation();

    if (location.equals("Avengers Compound") || location.equals("Stark Tower NYC")) {
        return location;
    }

    List<String> locations = new ArrayList<>();
    try {
        InputStream inputStream = ((Object) context).getAssets().open("data.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 8) {
                String avengerLocation = parts[7];
                if (avengerLocation.equals(location)) {
                    String realName = parts[0];
                    locations.add(realName);
                }
            }
        }

        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    if (locations.size() == 0) {
        return "unknown";
    } else if (locations.size() == 1) {
        return locations.get(0);
    } else {
        return "various locations";
    }
}
}