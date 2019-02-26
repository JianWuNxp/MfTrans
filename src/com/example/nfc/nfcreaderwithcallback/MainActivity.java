package com.example.nfc.nfcreaderwithcallback;

import android.nfc.NfcAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {
    final private static int READER_FLAGS = NfcAdapter.FLAG_READER_NFC_A | NfcAdapter.FLAG_READER_NFC_B;
    private CardReader mCardReader = new CardReader();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NfcAdapter adapter = NfcAdapter.getDefaultAdapter(this);
        if (adapter != null) {
            adapter.enableReaderMode(this, mCardReader, READER_FLAGS, null);
        }

    }
}
