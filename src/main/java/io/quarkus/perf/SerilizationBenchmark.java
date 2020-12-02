package io.quarkus.perf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.openjdk.jmh.annotations.*;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.MICROSECONDS;


@BenchmarkMode(Mode.AverageTime)
@Measurement(timeUnit = MICROSECONDS)
@OutputTimeUnit(MICROSECONDS)
public class SerilizationBenchmark {



    private static final String GSON_FILE = "/tmp/benchdata/capitals-gson-out.json";
    private static final String GSON_NOT_FLUSHING_FILE = "/tmp/benchdata/capitals-gson-not-flushing-out.json";
    private static final String JSONB_FILE = "/tmp/benchdata/capitals-jsonb-out.json";
    private static final String JSONB_OPTIMIZED_FILE = "/tmp/benchdata/capitals-jsonb-optimized-out.json";
    private static final String JACKSON_FILE = "/tmp/benchdata/capitals-jackson-out.json";

    @Benchmark
    public void testGsonNotFlushing(CapitalState capitalState) {
        List<CapitalState.Capital> targetList = new ArrayList<>(capitalState.getCapitolMap().values());
        Gson gson = new Gson();
        try {
            gson.toJson(targetList, new FileWriter(GSON_NOT_FLUSHING_FILE));
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


    @Benchmark
    public void testGson(CapitalState capitalState) {
        List<CapitalState.Capital> targetList = new ArrayList<>(capitalState.getCapitolMap().values());
        Gson gson = new Gson();
        try(FileWriter gsonFileWriter = new FileWriter(GSON_FILE)) {
            gson.toJson(targetList, gsonFileWriter);

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Benchmark
    public void testJsonB(CapitalState capitalState) {

        try {
            List<CapitalState.Capital> targetList = new ArrayList<>(capitalState.getCapitolMap().values());
            Jsonb jsonb = JsonbBuilder.create();
            String result = jsonb.toJson(targetList);
            Path path = Paths.get(JSONB_FILE);
            byte[] strToBytes = result.getBytes();
            Files.write(path, strToBytes);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Benchmark
    public void testJsonBFileWriter(CapitalState capitalState) {
        List<CapitalState.Capital> targetList = new ArrayList<>(capitalState.getCapitolMap().values());
        Jsonb jsonb = JsonbBuilder.create();
        try(FileWriter jsonBFileWriter = new FileWriter(JSONB_OPTIMIZED_FILE)) {
            jsonb.toJson(targetList, jsonBFileWriter);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }


    }

    @Benchmark
    public void testJackson(CapitalState capitalState) {

        List<CapitalState.Capital> targetList = new ArrayList<>(capitalState.getCapitolMap().values());
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(JACKSON_FILE), targetList);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }



}
