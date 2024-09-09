package code.app.spy.database;

import code.app.spy.beans.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MissionJDBC {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MissionJDBC(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Mission> getAllMissions() {
        String query = "SELECT * FROM mission";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Mission.class));
    }

    public List<Mission> getMissionByAgent(String agent) {
        String query = "SELECT * FROM mission where agent= :agent";
        Map<String, String> params = new HashMap<>();
        params.put("agent", agent);
        return jdbcTemplate.query(query, params, new BeanPropertyRowMapper<>(Mission.class));
    }

    public List<Mission> getMissionById(Integer id) {
        String query = "SELECT * FROM mission where id= :id";
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.query(query, params, new BeanPropertyRowMapper<>(Mission.class));
    }

    public void createMission(Mission mission) {
        String query = "INSERT INTO mission (agent, title, gadget1, gadget2)\n" +
                "VALUES\n" +
                "(:agent, :title, :gadget1, :gadget2)";

        Map<String,String> params = new HashMap<>();
        params.put("agent", mission.getAgent());
        params.put("title", mission.getTitle());
        params.put("gadget1", mission.getGadget1());
        params.put("gadget2", mission.getGadget2());

        jdbcTemplate.update(query, params);
    }

    public void editMissionById(Mission mission, Integer id) {
        String query = "UPDATE mission SET agent=:agent, title=:title, gadget1=:gadget1, gadget2=:gadget2 WHERE id=:id";

        Map<String,Object> params = new HashMap<>();
        params.put("id", id);
        params.put("agent", mission.getAgent());
        params.put("title", mission.getTitle());
        params.put("gadget1", mission.getGadget1());
        params.put("gadget2", mission.getGadget2());

        jdbcTemplate.update(query, params);
    }

    public void deleteMissionById(int id) {
        String query = "DELETE from mission where id=:id";
        Map<String,Object> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.update(query, params);

    }
}
