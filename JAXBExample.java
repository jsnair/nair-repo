package jaxb;



import javax.xml.bind.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 7/14/13
 * Time: 8:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class JAXBExample  {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\file.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            DefinitionsType definitionsType = new DefinitionsType();
            ProcessType processType = new ProcessType();
            processType.setId("myProcess");
            processType.setName("My Process");
            definitionsType.setProcess(processType);

            UserTaskType userTaskType = new UserTaskType();
            userTaskType.setId("userTask1");
            userTaskType.setName("UserTask");

            SequenceFlowType sequenceFlowType = new SequenceFlowType();
            sequenceFlowType.setId("flow1");
            sequenceFlowType.setSourceRef("usertask1");
            sequenceFlowType.setTargetRef("servicetask1");

            processType.getStartEventOrSequenceFlowOrUserTask().add(userTaskType);
            processType.getStartEventOrSequenceFlowOrUserTask().add(sequenceFlowType);


            JAXBElement<DefinitionsType> definitionsTypeJAXBElement = (new ObjectFactory().createDefinitions(definitionsType));
            JAXB.marshal(definitionsTypeJAXBElement,new FileOutputStream(new File("marshall.xml")));

        } catch (JAXBException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    }
