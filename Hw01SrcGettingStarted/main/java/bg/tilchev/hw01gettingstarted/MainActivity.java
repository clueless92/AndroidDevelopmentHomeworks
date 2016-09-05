package bg.tilchev.hw01gettingstarted;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private static int implicitButtonClickCount = 0;
    private static int explicitButtonClickCount = 0;

    private Button getExplicitButton() {
        View view = this.findViewById(R.id.explicit_button);
        if (view instanceof Button) {
            return (Button) view;
        }
        return null;
    }

    private Button getButton1() {
        View view = this.findViewById(R.id.ivanButton);
        if (view instanceof Button) {
            return (Button) view;
        }
        return null;
    }

    private Button getButton2() {
        View view = this.findViewById(R.id.peshoButton);
        if (view instanceof Button) {
            return (Button) view;
        }
        return null;
    }

    private Button getButton3() {
        View view = this.findViewById(R.id.goshoButton);
        if (view instanceof Button) {
            return (Button) view;
        }
        return null;
    }

    private TextView getTextView() {
        View view = this.findViewById(R.id.textView);
        if (view instanceof TextView) {
            return (TextView) view;
        }
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        Button explicitButton = this.getExplicitButton();
        if (explicitButton == null) {
            return;
        }
        explicitButton.setOnClickListener(this);

        Button button1 = this.getButton1();
        if (button1 == null) {
            return;
        }
        button1.setOnClickListener(this);

        Button button2 = this.getButton2();
        if (button2 == null) {
            return;
        }
        button2.setOnClickListener(this);

        Button button3 = this.getButton3();
        if (button3 == null) {
            return;
        }
        button3.setOnClickListener(this);

        TextView textView = this.getTextView();
        if (textView == null) {
            return;
        }
        textView.setOnClickListener(this);
    }

    public void onImplicitButtonClick(View view) {
        if (!(view instanceof Button)) {
            return;
        }
        if (view.getId() != R.id.implicit_button) {
            return;
        }
        Button implicitButton = (Button) view;
        if (implicitButton.getText().equals("Implicit Button")) {
            implicitButtonClickCount = 0;
        }
        implicitButtonClickCount++;
        implicitButton.setText(Integer.toString(implicitButtonClickCount));
    }

    // explicit button clicking => no reflection
    @Override
    public void onClick(View view) {
        if (view instanceof Button) {
            if (view.getId() == R.id.explicit_button) {
                this.onExplicitButtonClick(view);
            } else if (view.getId() == R.id.ivanButton) {
                this.onIvanButtonClick(view);
            } else if (view.getId() == R.id.peshoButton) {
                this.onPeshoButtonClick(view);
            } else if (view.getId() == R.id.goshoButton) {
                this.onGoshoButtonClick(view);
            }
        } else if (view instanceof TextView && view.getId() == R.id.textView) {
            this.onTextViewClick(view);
        }
    }

    private void onExplicitButtonClick(View view) {
        Button explicitButton = (Button) view;
        if (explicitButton.getText().equals("Explicit Button")) {
            explicitButtonClickCount = 0;
        }
        explicitButtonClickCount++;
        explicitButton.setText(Integer.toString(explicitButtonClickCount));
    }

    private void onIvanButtonClick(View view) {
        Button button = (Button) view;
        TextView textView = this.getTextView();
        if (textView == null) {
            return;
        }
        if (textView.getText().equals(button.getText())) {
            return;
        }
        if (textView.getText().equals(Integer.toString(R.id.ivanButton))) {
            textView.setText(button.getText());
            return;
        }
        textView.setText(Integer.toString(button.getId()));
    }

    private void onPeshoButtonClick(View view) {
        Button button = (Button) view;
        TextView textView = this.getTextView();
        if (textView == null) {
            return;
        }
        if (textView.getText().equals(button.getText())) {
            return;
        }
        if (textView.getText().equals(Integer.toString(R.id.peshoButton))) {
            textView.setText(button.getText());
            return;
        }
        textView.setText(Integer.toString(button.getId()));
    }

    private void onGoshoButtonClick(View view) {
        Button button = (Button) view;
        TextView textView = this.getTextView();
        if (textView == null) {
            return;
        }
        if (textView.getText().equals(button.getText())) {
            return;
        }
        if (textView.getText().equals(Integer.toString(R.id.goshoButton))) {
            textView.setText(button.getText());
            return;
        }
        textView.setText(Integer.toString(button.getId()));
    }

    private void onTextViewClick(View view) {
        TextView textView = (TextView) view;
        if (textView.getText().equals("New Text")) {
            return;
        }
        int componentID = Integer.parseInt(textView.getText().toString());
        String componentName = ((Button)this.findViewById(componentID))
                .getText().toString();
        String info = String.format("ID: %s%nName: %s", componentID, componentName);
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("info", info);
        this.startActivity(intent);
    }
}
