package com.ryg.chapter_2.manualbinder;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by liumeng on 2018/7/11 on 11:21
 */

public class Book1 implements Parcelable {
    public int bookId;
    public String bookName;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.bookId);
        dest.writeString(this.bookName);
    }

    public Book1() {
    }

    private Book1(Parcel in) {
        this.bookId = in.readInt();
        this.bookName = in.readString();
    }

    public static final Parcelable.Creator<Book1> CREATOR = new Parcelable.Creator<Book1>() {
        public Book1 createFromParcel(Parcel source) {
            return new Book1(source);
        }

        public Book1[] newArray(int size) {
            return new Book1[size];
        }
    };
}
