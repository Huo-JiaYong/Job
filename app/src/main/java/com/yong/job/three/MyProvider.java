package com.yong.job.three;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by jyong on 2016/3/29.
 */
public class MyProvider extends ContentProvider {

    private static final int BOOK_DIR = 0;
    private static final int BOOK_ITEM = 1;

    private static UriMatcher uriMatcher;

    private MyHelper helper;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.yong.job.provider", "book", BOOK_DIR);
        uriMatcher.addURI("com.yong.job.provider", "book/#", BOOK_ITEM);
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
                return "vnd.android.cursor.dir/vnd.com.yong.job.provider.book";
            case BOOK_ITEM:
                return "vnd.android.cursor.item/vnd.com.yong.job.provider.book";
            default:
                break;
        }
        return null;
    }

    @Override
    public boolean onCreate() {
        helper = new MyHelper(getContext(), "job.db", null, 1);
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = null;
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
                cursor = db.query("book", projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case BOOK_ITEM:
                String bookId = uri.getPathSegments().get(1);
                cursor = db.query("book", projection, "id=?", new String[]{bookId}, null, null, sortOrder);
                break;
        }
        return cursor;
    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = helper.getWritableDatabase();
        Uri uriReturn = null;
        switch (uriMatcher.match(uri)) {
            case BOOK_ITEM:
            case BOOK_DIR:
                long newBookId = db.insert("book", null, values);
                uriReturn = Uri.parse("content://com.yong.job.provider/book/" + newBookId);
                break;
        }
        return uriReturn;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = helper.getWritableDatabase();
        int row = 0;
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
                row = db.delete("book", selection, selectionArgs);
                break;
            case BOOK_ITEM:
                String bookId = uri.getPathSegments().get(1);
                row = db.delete("book", "id=?", new String[]{bookId});
                break;
            default:
                break;
        }
        return row;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db = helper.getWritableDatabase();
        int row = 0;
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
                row = db.update("book", values, selection, selectionArgs);
                break;
            case BOOK_ITEM:
                String bookId = uri.getPathSegments().get(1);
                row = db.update("book", values, "id = ?", new String[]{bookId});
                break;
            default:
                break;
        }
        return row;
    }

}
