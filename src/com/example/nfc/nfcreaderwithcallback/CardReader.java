package com.example.nfc.nfcreaderwithcallback;

import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.Ndef;
import android.util.Log;

import java.io.IOException;

/**
 * Created by nxp97381 on 2017/9/21.
 */

public class CardReader implements NfcAdapter.ReaderCallback {
    final private static String TAG = CardReader.class.getSimpleName();

    @Override
    public void onTagDiscovered(Tag tag) {
        Log.i (TAG, "WJ: onTagDiscovered! tag = " + tag);
        /*
        IsoDep isoTag = IsoDep.get (tag);
        if (isoTag != null)
        {
            Log.i (TAG, "WJ: ISO_DEP tag detected!");
        }
        Ndef ndefTag = Ndef.get(tag);
        if (ndefTag != null)
        {
            Log.i (TAG, "WJ: NDEF tag detected!");
            try {
                NdefMessage msg = ndefTag.getNdefMessage();
                Log.i (TAG, "WJ: msg = " + msg);
            } catch (IOException e) {
                Log.i (TAG, "WJ: IOException, " + e.getMessage());
                e.printStackTrace();
            } catch (FormatException e) {
                Log.i (TAG, "WJ: FormatException, " + e.getMessage());
                e.printStackTrace();
            }
        }
        */
        MifareClassic mfTag = MifareClassic.get(tag);
        if (mfTag != null)
        {
            byte[] data = { 0x00, 0x00, 0x05, 0x30, 0x01, 0x0A, 0x40, 0x05 };
            mfTag.setMode(1);
            try {
                mfTag.transceive(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
