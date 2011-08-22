/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.contacts.calllog;

import com.android.contacts.util.UriUtils;

import android.net.Uri;
import android.text.TextUtils;

/**
 * Information for a contact as needed by the Call Log.
 */
public final class ContactInfo {
    public Uri contactUri;
    public String name;
    public int type;
    public String label;
    public String number;
    public String formattedNumber;
    public String normalizedNumber;
    public Uri thumbnailUri;

    public static ContactInfo EMPTY = new ContactInfo();

    @Override
    public int hashCode() {
        // Uses only name and contactUri to determine hashcode.
        // This should be sufficient to have a reasonable distribution of hash codes.
        // Moreover, there should be no two people with the same contactUri.
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contactUri == null) ? 0 : contactUri.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ContactInfo other = (ContactInfo) obj;
        if (!UriUtils.areEqual(contactUri, other.contactUri)) return false;
        if (!TextUtils.equals(name, other.name)) return false;
        if (type != other.type) return false;
        if (!TextUtils.equals(label, other.label)) return false;
        if (!TextUtils.equals(number, other.number)) return false;
        // Ignore formatted number.
        if (!TextUtils.equals(normalizedNumber, other.normalizedNumber)) return false;
        if (!UriUtils.areEqual(thumbnailUri, other.thumbnailUri)) return false;
        return true;
    }
}