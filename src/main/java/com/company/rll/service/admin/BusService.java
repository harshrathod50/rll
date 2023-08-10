package com.company.rll.service.admin;

import com.company.rll.entity.admin.BusEntity;
import com.company.rll.repository.admin.BusRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusService {
  @Autowired
  BusRepository br;

  //adding
  public String addbus(BusEntity b) {
    if (b != null) {
      br.save(b);
      return "Bus Added";
    } else {
      return "Bus was not added";
    }
  }

  //editing

  //deleting
  public String deletebus(long bus_id) {
    br.deleteById(bus_id);
    return "Bus Removed";
  }

  //viewing all busses
  public List<BusEntity> showallbuses() {
    return br.findAll();
  }
}
