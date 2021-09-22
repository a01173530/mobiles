package mx.tec.androiddialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        final Toast myToast = new Toast(context);
        myToast.makeText(context, "I am a toast", Toast.LENGTH_SHORT).show();

        AlertDialog.Builder dialogConf = new AlertDialog.Builder(this);
        dialogConf.setTitle("Hi Dialog");
        dialogConf.setMessage("Are you sure?");

        dialogConf.setNeutralButton("Close",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        myToast.makeText(context, "You Clicked Cancel", Toast.LENGTH_SHORT).show();
                    }
                });

        dialogConf.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        myToast.makeText(context, "You Clicked Yes", Toast.LENGTH_SHORT).show();
                        // Do whatever you want here
                    }
                });

        dialogConf.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        myToast.makeText(context, "You Clicked No", Toast.LENGTH_SHORT).show();
                        // Do whatever you want here
                    }
                });

        AlertDialog myDialog = dialogConf.create();
        myDialog.show();

        int NOTIF_ID = 1234;
        Notification.Builder NotifBuilder = new Notification.Builder(this);
        NotifBuilder.setSmallIcon(R.mipmap.ic_launcher);
        NotifBuilder.setContentTitle("Important Notification");
        NotifBuilder.setContentText("This is the detail of the notification");

        Intent notificationIntent = new Intent(context, ChildActivity.class);

        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);

        NotifBuilder.setContentIntent(contentIntent);

        NotificationManager MyNotification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        MyNotification.notify(NOTIF_ID, NotifBuilder.build());

     }
}