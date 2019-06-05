package com.example.bracketstop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 *  This is the main class
 *  It uses all other classes and creates the GUEY
 *
 *  @author  Bridget Naylor
 *  @version May 16, 2019
 *  @author  Period: 1
 *  @author  Assignment: Final_Project_TornamentBracketSystem
 *
 *  @author  Sources: MYSELF
 */

public class MainActivity extends AppCompatActivity{

    //Queue of winning and losing wrestlers(player)
    Queue<Player> winnersQueue = new LinkedList<Player>();
    Queue<Player> losersQueue = new LinkedList<Player>();

    //Creates TournamentBracket object to store winning and losing queues
    TournamentBracket fourManQueue = new TournamentBracket(4, winnersQueue, losersQueue );

    //create wrestler object
    public EditText wrestlerName;
    public EditText wrestlerGrade;
    public EditText wrestlerSchool;

    //Strings used to initiatize Player objects
    String wName = "";
    String wSchool = "";
    String wresGrade = "";
    String wresWeight = "";

    //keeps track of current win type
    String winType = "";

    //Gets weight class
    EditText weightClassDisplay;

    //Booleans used to determine if save has been pressed after a winner is selected
    boolean firstMatchDone = false;
    boolean secondMatchDone = false;
    boolean championMatchDone = false;

    //Initial list of added Wrestlers
    List<Player> wrestlerList = new ArrayList<Player>();

    //List used to place Players on the podium
    List<String> podiumOrder = new ArrayList<String>();

    //size of wrestler list
    public int sizeWrestlerList;

    /**
     * Creates original screen
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    /**
     * adds a wrestler object into the list of wrestlers
     * @param view allows method to be see by GUI
     */
    void addWrestler(View view){
        boolean SOMETHINGEQUALSNULL = false;

        //Converts edittext to strings
        int wGrade = 0;
        int wWeight = 0;
        if ( sizeWrestlerList > 4) {
            Toast.makeText(getApplicationContext(), "You cannot add more than 4 players press done again", Toast.LENGTH_SHORT).show();
            wrestlerList.remove(wrestlerList.size() - 1);
        } else {
            //Tests to see if user inputed any values for name,school, weight, grade
            //sets default values if user did not set values
            wrestlerName = (EditText) findViewById(R.id.enter_wrestler_name);
            wName = wrestlerName.getText().toString();
            if (wName.matches("")) {
                SOMETHINGEQUALSNULL = true;
                System.out.println("LAMEHORSE1");
                wName = "No Name Entered";
            }

            wrestlerSchool = (EditText) findViewById(R.id.enter_wrestler_school);
            wSchool = wrestlerSchool.getText().toString();
            if (wSchool.matches("")) {
                SOMETHINGEQUALSNULL = true;
                System.out.println("LAMEHORSE2");
                wSchool = "School Not Specified";
            }

            wrestlerGrade = (EditText) findViewById(R.id.enter_wrestler_grade);
            wresGrade = wrestlerGrade.getText().toString();

            System.out.println("LAMEHORSE10 " + wresGrade);
            if (wresGrade.matches("")) {
                SOMETHINGEQUALSNULL = true;
                System.out.println("LAMEHORSE3");
                wGrade = 0;
            }


            if (wresWeight.matches("")) {
                SOMETHINGEQUALSNULL = true;
                System.out.println("LAMEHORSE4");
                wWeight = 0;
            }
            //converts String to integers
            if (!wresGrade.equals("0") && !wresGrade.equals("")) {
                wGrade = Integer.parseInt(wresGrade);
                System.out.println("LAMEHORSE40" + wGrade);

            }
            if (wWeight != 0) {
                wWeight = Integer.parseInt(wresWeight);
            }

            //Initiatizes and adds a new player object to the list
            Player addNext = new Player(wName, wSchool, wGrade, wWeight);
            wrestlerList.add(addNext);

            //Used for debugging
//        System.out.println("NAME " + wName);
//        System.out.println("SCHOOL " + wSchool);
//        System.out.println("GRADE " + wGrade);
//        System.out.println("WEIGHT CLASS " + wWeight);


            if (SOMETHINGEQUALSNULL) {
                System.out.println("SOMETHINGEQUALSNULL");
            }
            setContentView(R.layout.wrestling_object_adding);
        }
    }

    /**
     * If done adding wrestlers shows bracket scene
     * @param view allows method to be see by GUI
     */
    void doneAddingWrestlers(View view){
        sizeWrestlerList = wrestlerList.size();
        System.out.println("WrestlerListSize " + sizeWrestlerList);

        if (sizeWrestlerList == 1){
            setContentView(R.layout.results_one_man_display);
            Button but = (Button)findViewById(R.id.winner_one_man);
            but.setText(wrestlerList.get(0).getName());
            Toast.makeText(getApplicationContext(), "Wow...Congrats " + wrestlerList.get(0).getName() + " you must feel sooooooooo good about yourself", Toast.LENGTH_SHORT).show();
            return;
        } else if (sizeWrestlerList == 0){
            Toast.makeText(getApplicationContext(), "You have not entered any players :(", Toast.LENGTH_SHORT).show();
            return;
        }

        if ( sizeWrestlerList > 4) {
            Toast.makeText(getApplicationContext(), "You cannot add more than 4 players press done again", Toast.LENGTH_SHORT).show();
            wrestlerList.remove(wrestlerList.size() - 1);
        } else {
    //takes user input and creates the correct amount of screens
    //each screen has the right sized bracket
    //decides what size bracket to use
        //sets weight class display
        if (sizeWrestlerList >= 1 && sizeWrestlerList < 3){//two man bracket
            setContentView(R.layout.two_man_bracket_template);
            TextView weightDisplay = (TextView)findViewById(R.id.display_wrestler_weightclass);
            weightDisplay.setText(wresWeight);


            for (int i = 0; i < wrestlerList.size(); i++){
                System.out.println("ITWORKED " + wrestlerList.get(i).getName());

                //Shows button text
                Button but = (Button)findViewById(R.id.finalist + i + 1);
                but.setText(wrestlerList.get(i).getName());

                TextView schoolDisplay = (TextView)findViewById(R.id.school + i + 1);
                schoolDisplay.setText(wrestlerList.get(i).getSchool() +"");

                TextView gradeDisplay = (TextView)findViewById(R.id.grade + i + 1);
                gradeDisplay.setText(wrestlerList.get(i).getGrade() + "");

            }
        } else if (sizeWrestlerList > 2 && sizeWrestlerList < 5){//four man bracket
            System.out.println("ITWORKED " + sizeWrestlerList);
            setContentView(R.layout.four_man_bracket_template);
            TextView weightDisplay = (TextView)findViewById(R.id.display_wrestler_weightclass);
            weightDisplay.setText(wresWeight);
            if (wrestlerList.size() == 3){
                int weight = Integer.parseInt(wresWeight);
                Player forfeit = new Player("forfeit", "", 0 , weight);
                wrestlerList.add(forfeit);
            }
            for (int i = 0; i < wrestlerList.size(); i++){

                //Shows button text
                Button but = (Button)findViewById(R.id.semifinalist + i + 1);
                but.setText(wrestlerList.get(i).getName());
            }
            if (firstMatchDone && !secondMatchDone){
                Button but = (Button)findViewById(R.id.finalist1_four_man);
                but.setText(winnersQueue.peek().getName());

            }  else if (secondMatchDone && firstMatchDone){

                Button but = (Button)findViewById(R.id.finalist1_four_man);
                Player firstWinner = winnersQueue.peek();
                but.setText(firstWinner.getName());
                winnersQueue.remove();
                Button but1 = (Button)findViewById(R.id.finalist2_four_man);
                Player secondWinner = winnersQueue.peek();
                but1.setText(secondWinner.getName());
                winnersQueue.remove();

                winnersQueue.add(firstWinner);
                winnersQueue.add(secondWinner);
            }
        }
        }
    }

    /**
     * OnClick sets the first player as the champion of twoman bracket
     * @param view allows method to be see by GUI
     */
    void selectChampionTwoMan(View view){
        Button showWinner = (Button)findViewById(R.id.finalist);
        showWinner.setText(wrestlerList.get(0).getName());

        TextView gradeDisplay = (TextView)findViewById(R.id.grade );
        gradeDisplay.setText(wrestlerList.get(0).getGrade() + "");

        TextView schoolDisplay = (TextView)findViewById(R.id.school );
        schoolDisplay.setText(wrestlerList.get(0).getSchool() +"");
    }

    /**
     * OnClick sets the second player as the champion of twoman bracket
     * @param view allows method to be see by GUI
     */
    void selectChampionTwoMan2(View view){
        Button showWinner = (Button)findViewById(R.id.finalist);
        showWinner.setText(wrestlerList.get(1).getName());

        TextView gradeDisplay = (TextView)findViewById(R.id.grade );
        gradeDisplay.setText(wrestlerList.get(1).getGrade() + "");

        TextView schoolDisplay = (TextView)findViewById(R.id.school);
        schoolDisplay.setText(wrestlerList.get(1).getSchool() +"");
    }

    /**
     * OnClick selects first player in list as semifinalist in four man bracket
     * @param view allows method to be see by GUI
     */
    void selectFinalist(View view){
        if (firstMatchDone){
            return;
        }
        Button showWinner = (Button)findViewById(R.id.finalist1_four_man);
        showWinner.setText(wrestlerList.get(0).getName());

    }

    /**
     * OnClick selects second player in list as semifinalist in four man bracket
     * @param view allows method to be see by GUI
     */
    void selectFinalist2(View view){
        if (firstMatchDone){
            return;
        }
        Button showWinner = (Button)findViewById(R.id.finalist1_four_man);
        showWinner.setText(wrestlerList.get(1).getName());

    }

    /**
     * OnClick selects third player in list as semifinalist in four man bracket
     * @param view allows method to be see by GUI
     */
    void selectFinalist3(View view){
        if (secondMatchDone){
            return;
        }
        Button showWinner = (Button)findViewById(R.id.finalist2_four_man);
        showWinner.setText(wrestlerList.get(2).getName());

    }

    /**
     * OnClick selects fourth player in list as semifinalist in four man bracket
     * @param view allows method to be see by GUI
     */
    void selectFinalist4(View view){
        if (secondMatchDone){
            return;
        }
        Button showWinner = (Button)findViewById(R.id.finalist2_four_man);
        showWinner.setText(wrestlerList.get(3).getName());

    }


    /**
     * OnClick selects player in button id finalist1_four_man as champion in four man bracket
     * @param view allows method to be see by GUI
     */
    void selectChampion3(View view){
        System.out.println("MakeSchool ");
        if (!firstMatchDone){
            return;
        }
        Button showWinner = (Button)findViewById(R.id.semifinalist);
        Button player1 = (Button)findViewById(R.id.finalist1_four_man);

        String player1Name = player1.getText().toString();

        showWinner.setText(player1Name);

    }

    /**
     * OnClick selects player in button id finalist2_four_man as champion in four man bracket
     * @param view allows method to be see by GUI
     */
    void selectChampion4(View view){
        if (!secondMatchDone){
            return;
        }
        Button showWinner = (Button)findViewById(R.id.semifinalist);
        Button player2 = (Button)findViewById(R.id.finalist2_four_man);
        String player2Name = player2.getText().toString();
        showWinner.setText(player2Name);

    }

    /**
     * OnClick selects player in button id finalist1 as third place in four man bracket
     * @param view allows method to be see by GUI
     */
    void selectThirdPlace(View view){
        Button showWinner = (Button)findViewById(R.id.finalist);
        Button player2 = (Button)findViewById(R.id.finalist1);
        String player2Name = player2.getText().toString();
        showWinner.setText(player2Name);

    }

    /**
     * OnClick selects player in button id finalist11 as third place in four man bracket
     * @param view allows method to be see by GUI
     */
    void selectThirdPlace2(View view){
        Button showWinner = (Button)findViewById(R.id.finalist);
        Button player2 = (Button)findViewById(R.id.finalist11);
        String player2Name = player2.getText().toString();
        showWinner.setText(player2Name);

    }

    /**
     * OnClick saves results two man and traverses to results page
     * places correct players on results page
     * @param view allows method to be see by GUI
     */
    void onSaveTwoMan(View view){
        System.out.println("Inside SAVE");

        Button championTwoMan = (Button)findViewById(R.id.finalist);
        System.out.println("championTwoMan " + championTwoMan.getText().toString());
        String firstPlaceTwoMan = championTwoMan.getText().toString();
        String secondPlaceTwoMan = "";
        if (wrestlerList.get(0).getName().equals(firstPlaceTwoMan)){
            wrestlerList.remove(0);
            secondPlaceTwoMan = wrestlerList.get(0).getName();
        } else {
            wrestlerList.remove(1);
            secondPlaceTwoMan = wrestlerList.get(0).getName();
        }

        setContentView(R.layout.results_two_man_display);
        Button placeFirstPlaceTwoMan = (Button)findViewById(R.id.first_place_two_man);
        Button placeSecondPlaceTwoMan = (Button)findViewById(R.id.second_place_two_man);
        placeFirstPlaceTwoMan.setText(firstPlaceTwoMan);
        placeSecondPlaceTwoMan.setText(secondPlaceTwoMan);
    }

    /**
     * OnClick adds winners and losers to correct queues
     * does not allow placement changes-> making buttons toast an error if clicked
     * @param view allows method to be see by GUI
     */
    void onSaveFourManFirstSave(View view){

        Button but = (Button)findViewById(R.id.finalist1_four_man);
        System.out.println("Inside SAVEFour");
        System.out.println("Inside SAVEFourFirst " + but.getText().toString());
        if (but.getText().toString().equals("")){
            Toast.makeText(this, "Please select a winner before saving", Toast.LENGTH_SHORT).show();
            return;
        }
        if (firstMatchDone){
            Toast.makeText(this, "A winner has already been saved", Toast.LENGTH_SHORT).show();
            return;
        }
        Button placeFinalist = (Button)findViewById(R.id.finalist1_four_man);
        String finalistFourMan = placeFinalist.getText().toString();
        if (wrestlerList.get(0).getName().equals(finalistFourMan)){
            fourManQueue.addPlayer(winnersQueue,wrestlerList.get(0));
            fourManQueue.addPlayer(losersQueue,wrestlerList.get(1));
            System.out.println("onSaveFourManFirstSaveWinner " + wrestlerList.get(0).getName());
            System.out.println("onSaveFourManFirstSaveLoser " + wrestlerList.get(1).getName());
        } else if (wrestlerList.get(1).getName().equals(finalistFourMan)){
            fourManQueue.addPlayer(losersQueue,wrestlerList.get(0));
            fourManQueue.addPlayer(winnersQueue,wrestlerList.get(1));
            System.out.println("onSaveFourManFirstSaveWinner " + wrestlerList.get(1).getName());
            System.out.println("onSaveFourManFirstSaveLoser " + wrestlerList.get(0).getName());
        }
//        System.out.println("LOOKHERETODAY " + winnersQueue.peek().getName());
//        System.out.println("LOOKHERETODAY " + losersQueue.peek().getName());
//        System.out.println("LOOKHERETODAY " + winnersQueue.peek());
//        System.out.println("LOOKHERETODAY " + winnersQueue.peek());

        firstMatchDone = true;
    }

    /**
     * OnClick adds winners and losers to correct queues
     * does not allow placement changes-> making buttons toast an error if clicked
     * @param view allows method to be see by GUI
     */
    void onSaveFourManSecondSave(View view){
        Button but = (Button)findViewById(R.id.finalist2_four_man);
        System.out.println("Inside SAVEFour");
        System.out.println("Inside SAVEFour " + but.getText().toString());
        if (but.getText().toString().equals("")){
            Toast.makeText(this, "Please select a winner before saving", Toast.LENGTH_SHORT).show();
            return;
        }
        if (secondMatchDone){
            Toast.makeText(this, "A winner has already been save", Toast.LENGTH_SHORT).show();
            return;
        }
        System.out.println("Inside SAVEFour");
        Button placeFinalist = (Button)findViewById(R.id.finalist2_four_man);
        String finalistFourMan = placeFinalist.getText().toString();
        if (wrestlerList.get(2).getName().equals(finalistFourMan)){
            fourManQueue.addPlayer(winnersQueue,wrestlerList.get(2));
            fourManQueue.addPlayer(losersQueue,wrestlerList.get(3));
            System.out.println("onSaveFourManSecondSaveWinner " + wrestlerList.get(2).getName());
            System.out.println("onSaveFourManSecondSaveLoser " + wrestlerList.get(3).getName());
        } else {
            fourManQueue.addPlayer(winnersQueue,wrestlerList.get(3));
            fourManQueue.addPlayer(losersQueue,wrestlerList.get(2));
            System.out.println("onSaveFourManSecondSaveWinner " + wrestlerList.get(3).getName());
            System.out.println("onSaveFourManSecondSaveLoser " + wrestlerList.get(2).getName());

        }

        System.out.println("LOOKHERETODAY " + winnersQueue.peek());
        System.out.println("LOOKHERETODAY " + losersQueue.peek());
        secondMatchDone = true;
    }


    /**
     * OnClick saves results and traverses to results page
     * places correct players on results page
     * @param view allows method to be see by GUI
     */
    void onSaveFourManThird(View view){
        System.out.println("Inside SAVEFour");
        Button but = (Button)findViewById(R.id.semifinalist);
        System.out.println("Inside SAVEFour");
        System.out.println("Inside SAVEFour " + but.getText().toString());
        if (but.getText().toString().equals("")){
            Toast.makeText(this, "Please select a winner before saving", Toast.LENGTH_SHORT).show();
            return;
        }

        Button placeChampion = (Button)findViewById(R.id.semifinalist);
        String championFourMan = placeChampion.getText().toString();
        if (winnersQueue.peek().getName().equals(championFourMan)){
            podiumOrder.add(championFourMan);
            winnersQueue.remove();
            podiumOrder.add(winnersQueue.peek().getName());
        } else if (!winnersQueue.peek().getName().equals(championFourMan)){
            String fourthPlace = winnersQueue.peek().getName();
            winnersQueue.remove();
            podiumOrder.add(winnersQueue.peek().getName());
            podiumOrder.add(fourthPlace);
        }



        setContentView(R.layout.four_man_cons_bracket_template);
        TextView weightDisplay = (TextView)findViewById(R.id.display_wrestler_weightclass);
        weightDisplay.setText(wresWeight);
        Button conslPlace1 = (Button)findViewById(R.id.finalist1);
        Button cons2Place1 = (Button)findViewById(R.id.finalist11);
        conslPlace1.setText(losersQueue.peek().getName());
        losersQueue.remove();
        cons2Place1.setText(losersQueue.peek().getName());
        championMatchDone = true;
    }

    /**
     * displays queue screen and allows traversal between queue screen and four man bracket screen
     * @param view allows method to be see by GUI
     */
    void showQueue(View view){
        setContentView(R.layout.queue_display);
        // sets text for queues
        TextView wrestlingNow = (TextView)findViewById(R.id.queue1);
        TextView wrestlingNext = (TextView)findViewById(R.id.queue2);

        if (!firstMatchDone && !secondMatchDone){
            wrestlingNow.setText( wrestlerList.get(0).getName() + " vs. " + wrestlerList.get(1).getName());
            wrestlingNext.setText( wrestlerList.get(2).getName() + " vs. " + wrestlerList.get(3).getName());
            return;
        }
        if (firstMatchDone && !secondMatchDone){
            wrestlingNow.setText( wrestlerList.get(2).getName() + " vs. " + wrestlerList.get(3).getName());
            wrestlingNext.setText("");
            return;
        } else if (secondMatchDone && ! firstMatchDone){
            wrestlingNow.setText( wrestlerList.get(0).getName() + " vs. " + wrestlerList.get(1).getName());
            wrestlingNext.setText("");
            return;
        } else if (secondMatchDone && firstMatchDone){
            Player firstWinner = winnersQueue.peek();
            winnersQueue.remove();
            Player secondWinner = winnersQueue.peek();
            winnersQueue.remove();
            wrestlingNow.setText(firstWinner.getName() + " vs. " + secondWinner.getName() );

            Player firstLoser = losersQueue.peek();
            losersQueue.remove();
            Player secondLoser = losersQueue.peek();
            losersQueue.remove();
            wrestlingNext.setText(firstLoser.getName() + " vs. " + secondLoser.getName());


            winnersQueue.add(firstWinner);
            winnersQueue.add(secondWinner);

            losersQueue.add(firstLoser);
            losersQueue.add(secondLoser);
            return;
        }

    }

    /**
     * shows the results of the four man bracket
     * @param view allows method to be see by GUI
     */
    void showFourManBracketResults (View view){
        Button placeFinalist = (Button)findViewById(R.id.finalist);
        String championFourMan = placeFinalist.getText().toString();
        if (championFourMan.equals("")){
            Toast.makeText(this, "Please select a winner", Toast.LENGTH_SHORT).show();
            return;
        }
        podiumOrder.add(championFourMan);
        for (int i = 0; i < wrestlerList.size(); i++){
            if (!podiumOrder.contains(wrestlerList.get(i).getName())){
                podiumOrder.add(wrestlerList.get(i).getName());
            }
        }
        setContentView(R.layout.results_four_man_display);

        Button but = (Button)findViewById(R.id.winner_four_man);
        but.setText(podiumOrder.get(0));

        Button but1 = (Button)findViewById(R.id.second_four_man);
        but1.setText(podiumOrder.get(1));

        Button but2 = (Button)findViewById(R.id.third_four_man);
        but2.setText(podiumOrder.get(2));

        Button but3 = (Button)findViewById(R.id.fourth_four_man);
        but3.setText(podiumOrder.get(3));

    }

    /**
     * sets current win type to pin
     * @param view allows method to be see by GUI
     */
    void onPinTwoMan(View view){
        winType = "Pin";
    }

    /**
     * sets current win type to points
     * @param view allows method to be see by GUI
     */
    void onPointsTwoMan(View view){
        winType = "Points";
    }

    /**
     * displays the main screen UI
     * @param view allows method to be see by GUI
     */
    void showMain (View view){
        setContentView(R.layout.activity_main);
    }

    /**
     * displays the wrestler adder UI
     * @param view allows method to be see by GUI
     */
    void showWrestlerAdder(View view){
        weightClassDisplay = (EditText) findViewById(R.id.enter_weight_class);
        wresWeight = weightClassDisplay.getText().toString();
        if (wresWeight.equals("")){
            Toast.makeText(getApplicationContext(), "Add weight class", Toast.LENGTH_SHORT).show();
            return;
        }

        setContentView(R.layout.wrestling_object_adding);
    }

    /**
     * displays the four man bracket UI
     * @param view allows method to be see by GUI
     */
    void showFourManBracket(View view){

        setContentView(R.layout.four_man_bracket_template);
        doneAddingWrestlers(view);
    }

    /**
     * displays the four man consolation bracket UI
     * @param view allows method to be see by GUI
     */
    void showFourManConsBracket(View view){
        setContentView(R.layout.four_man_cons_bracket_template);
    }

    /**
     * displays the results of a one man bracket
     * @param view allows method to be see by GUI
     */
    void showResultsOneMan(View view){
        setContentView(R.layout.results_one_man_display);
    }

    /**
     * displays the results of a two man bracket
     * @param view allows method to be see by GUI
     */
    void showResultsTwoMan(View view){
        setContentView(R.layout.results_two_man_display);
    }

    /**
     * displays a toast that says useless button
     * @param view allows method to be see by GUI
     */
    void showUselessButtonText(View view){
        Button but = (Button)findViewById(R.id.semifinalist);
        System.out.println("Inside SAVEFour");
        System.out.println("Inside SAVEFour " + but.getText().toString());
        if (but.getText().toString().equals("")){
            Toast.makeText(this, "Congrats you are clicking on a useless button", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    /**
     * toasts a mean message
     * @param view allows method to be see by GUI
     */
    void toastToFourthPlace(View view){

        Toast.makeText(this, "Congrats on being the last winner!!! ", Toast.LENGTH_SHORT).show();
    }

    /**
     * toasts mean second place
     * @param view allows method to be see by GUI
     */
    void toastToSecondPlace(View view){

        Toast.makeText(this, "No one remembers second place...", Toast.LENGTH_SHORT).show();
    }
}


