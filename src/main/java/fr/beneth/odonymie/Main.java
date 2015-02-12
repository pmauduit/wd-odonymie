package fr.beneth.odonymie;

import org.wikidata.wdtk.datamodel.json.jackson.JsonSerializer;
import org.wikidata.wdtk.dumpfiles.DumpProcessingController;

public class Main {

    public static void main(String argv[]) {

        JsonSerializer jsonSerializer = new JsonSerializer(System.out);
        jsonSerializer.start();
        DumpProcessingController dumpProcessingController = new DumpProcessingController("wikidatawiki");
        dumpProcessingController.registerEntityDocumentProcessor(jsonSerializer, null, true);
        
        dumpProcessingController.processMostRecentMainDump();
    }

}