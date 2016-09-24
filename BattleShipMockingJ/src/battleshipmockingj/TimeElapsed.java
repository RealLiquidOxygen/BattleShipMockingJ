/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipmockingj;
//this handles the session timer for each game session
public class TimeElapsed{
    
long startTime = System.currentTimeMillis();

public Thread timerCounterReal = null;

public TimeElapsed() {



//starting new Thread which will update time
timerCounterReal = new Thread(() -> { 
    try {
        updateTime();
    }
    catch (Exception ie) 
    { }
});
timerCounterReal.start();
}

public void updateTime() {
try {
    while(true)
    {
    //geting Time in desire format
    BattleShipMainDisplay.jLabelTime.setText(getTimeElapsed());
    //Thread sleeping for 1 sec
    Thread.currentThread().sleep(1000);
    }
}catch (Exception e)
    {
        System.out.println("Exception in Thread Sleep : "+e);
        BattleShipMainDisplay.jLabelTime.setText("00:00:00");
    }
}

//formats the timer that is displayed
public String getTimeElapsed()
{
long elapsedTime = System.currentTimeMillis() - startTime;
elapsedTime = elapsedTime / 1000;

String seconds = Integer.toString((int)(elapsedTime % 60));
String minutes = Integer.toString((int)((elapsedTime % 3600) / 60));
String hours = Integer.toString((int)(elapsedTime / 3600));

if (seconds.length() < 2){
seconds = "0" + seconds;
}

if (minutes.length() < 2){
minutes = "0" + minutes;
}

if (hours.length() < 2){
hours = "0" + hours;
}

return hours+":"+minutes+":"+seconds;
}

}