package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.Bookmark;
import ru.kpfu.itis.model.User;

import java.util.List;

public interface BookmarkRepository {

    void addBookmark(Bookmark bookmark);

    List<Bookmark> allUserBookmarks(User user);
}
