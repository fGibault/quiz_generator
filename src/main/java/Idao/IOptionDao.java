package Idao;

import models.Options;

import java.util.List;

public interface IOptionDao {
    List<Options> getAllOptions();
    Options getOption(int id);
    void addOption(Options options);
    void updateOption(Options options);
    void deleteOption(int id);
}
