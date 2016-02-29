package deltaanalytics.bruker.data.repository;

public class CleanTestMemDB {
    public static void cleanUp(){
        new MeasureSampleRepository().deleteAll();
        new MeasureSampleResultRepository().deleteAll();
        new MeasureReferenceRepository().deleteAll();
        new BrukerParametersRepository().deleteAll();
    }
}
