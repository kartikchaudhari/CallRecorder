/*
 * Copyright (C) 2019 Eugen Rădulescu <synapticwebb@gmail.com> - All rights reserved.
 *
 * You may use, distribute and modify this code only under the conditions
 * stated in the SW Call Recorder license. You should have received a copy of the
 * SW Call Recorder license along with this file. If not, please write to <synapticwebb@gmail.com>.
 */

package net.synapticweb.callrecorder.contactdetail;

import android.net.Uri;
import net.synapticweb.callrecorder.CrApp.DialogInfo;
import net.synapticweb.callrecorder.data.Contact;
import net.synapticweb.callrecorder.data.Recording;
import java.util.List;
import androidx.annotation.NonNull;

public interface ContactDetailContract {
    interface View {
        void setContact(Contact contact);
        void paintViews(List<Recording> recordings);
        boolean isInvalid();
        void setInvalid(boolean invalid);
        void removeRecording(Recording recording);
    }

    interface ContactDetailPresenter {
        void loadRecordings(Contact contact);
        DialogInfo deleteContact(Contact contact);
        DialogInfo deleteRecordings(List<Recording> recordings);
        DialogInfo renameRecording(CharSequence input, Recording recording);
        DialogInfo assignToContact(Uri numberUri, List<Recording> recordings, Contact contact);
        DialogInfo assignToPrivate(List<Recording> recordings, Contact contact);
    }
}
