package iaf.ofek.hadracha.base_course.web_server.EjectedPilotRescue;

import iaf.ofek.hadracha.base_course.web_server.Data.InMemoryMapDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/ejectedPilotRescue")

@RestController
public class EjectionsRestControl {
    public InMemoryMapDataBase inMemoryMapDataBase;
    public AirplanesAllocationManager airplanesAllocationManager;

    @Autowired
    public EjectionsRestControl(InMemoryMapDataBase inMemoryMapDataBase, AirplanesAllocationManager airplanesAllocationManager) {
        this.airplanesAllocationManager = airplanesAllocationManager;
        this.inMemoryMapDataBase = inMemoryMapDataBase;
    }

    @GetMapping("/infos")
    public List<EjectedPilotInfo> SendEjectionToClient() {
        return inMemoryMapDataBase.getAllOfType(EjectedPilotInfo.class);
    }
}
