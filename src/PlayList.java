import java.util.ArrayList;
public class PlayList {
    public static int MAX_NUMBER_SONGS = 5;
    private String listName; // name of playlist
    private ArrayList<Song> songs;
    private ArrayList<Integer> stars; // how many stars each song has

    public PlayList(String name) {
      listName = name;
      songs = new ArrayList<Song>();
      stars = new ArrayList<Integer>();
    }

    public double averageRating() {
      // returns the average star rating for the list
      double total = 0;
      int numItems = songs.size();
      for (int i = 0; i < numItems; i++) {
        total += stars.get(i);
      }
      return total / numItems;
    }

    public ArrayList<Song> getSongs() {
      return songs;
    }

    public double averageRating(Artist artist) {
      // returns the mean star rating associated with artist
      double total = 0;
      int numItems = songs.size();
      for (int i = 0; i < songs.size(); i++) {
        if (songs.get(i).getArtist().equals(artist)) {
          total += stars.get(i);
        }
      }
      return total / numItems;
    }

    public Song[] getSongs(Artist artist) {
      // returns an array populated by the songs of parameter artist
      int count = 0;
      for (int i = 0; i < songs.size(); i++) {
        if (songs.get(i).getArtist().equals(artist)) {
          count++;
        }
      }
      Song[] result = new Song[count];
      int index = 0;
      for (int i = 0; i < songs.size(); i++) {
        if (songs.get(i).getArtist().equals(artist)) {
          result[index] = songs.get(i);
          index++;
        }
      }
      return result;
    }

    public ArrayList<Artist> getArtist(String songName) {
      // returns an ArrayList of all Artists associated with the String songName
      ArrayList<Artist> result = new ArrayList<Artist>();
      for (int i = 0; i < songs.size(); i++) {
        if (songs.get(i).getName().equals(songName)) {
          result.add(songs.get(i).getArtist());
        }
      }
      return result;
    }

    private int indexOf(Song someSong) {
      for (int i = 0; i < songs.size(); i++) {
        if (songs.get(i).equals(someSong)) {
          return i;
        }
      }
      return -1;
    }

    public String toString() {
      // returns an appropriate String representation of the PlayList
      String result = "[Name: " + listName + ", Songs: " + songs + "]";
      return result;
    }

    public void swap(Song song1, Song song2) {
      // switches positions of these two (maintain parallelism!)
      if (indexOf(song1) > -1 || indexOf(song2) > -1) {
        songs.set(indexOf(song1), song2);
        songs.set(indexOf(song2), song1);
        stars.set(indexOf(song1), stars.get(indexOf(song2)));
        stars.set(indexOf(song2), stars.get(indexOf(song1)));
      }
    }

    public boolean add(Song _song, int _stars) {
      // adds data if number of song is less than MAX_NUMBER_SONGS
      if (songs.size() >= MAX_NUMBER_SONGS) {
        return false;
      } else {
        songs.add(_song);
        stars.add(_stars);
        return true;
      }
    }

    public void removeSong(Song song, Artist artist) {
      // removes all occurrences of song by artist; there could be multiple instances of song
      for (int i = 0; i < songs.size(); i++) {
        if (songs.get(i).getArtist().equals(artist) && songs.get(i).equals(song)) {
          songs.remove(i);
          stars.remove(i);
        }
      }
    }

    public void removeArtist(Artist artist) {
      // removes all elements associated with artist
      for (int i = songs.size() - 1; i >= 0; i--) {
        if (songs.get(i).getArtist().equals(artist)) {
          songs.remove(i);
          stars.remove(i);
        }
      }
    }

    public void removeLowStars(int cutOff) {
      // removes all elements associated with a star rating less than cutOff
      for (int i = stars.size() - 1; i >= 0; i--) {
        if (stars.get(i) < cutOff) {
          stars.remove(i);
          songs.remove(i);
        }
      }
    }
}
