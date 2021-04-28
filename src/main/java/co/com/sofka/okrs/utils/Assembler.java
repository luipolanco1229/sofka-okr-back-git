package co.com.sofka.okrs.utils;

import co.com.sofka.okrs.dashboard_dto.KrTable;
import co.com.sofka.okrs.dashboard_dto.OkrList;
import co.com.sofka.okrs.dashboard_dto.OkrTable;
import co.com.sofka.okrs.dashboard_dto.UserView;
import co.com.sofka.okrs.domain.Kr;
import co.com.sofka.okrs.domain.Okr;
import co.com.sofka.okrs.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.ArrayList;
import java.util.List;

public class Assembler {

    public static UserView generateUserView(User user){
        return new UserView(user.getName(), user.getEmail());
    }

    public static OkrList generateOkrList(Okr okr){
        return new OkrList(okr.getId(), okr.getTitle(), okr.getAdvanceOkr());
    }

    public static Mono<OkrTable> generateOkrTable(Mono<Okr> okr, Flux<Kr> krs){
        OkrTable okrTable = new OkrTable();
        List<KrTable> krTable = generatekrTable(krs);
        return okr.flatMap(okr1 ->{
            okrTable.setTitle(okr1.getTitle());
            okrTable.setObjective(okr1.getObjective());
            okrTable.setPersonInChargeNameOkr(okr1.getPersonInChargeNameOkr());
            okrTable.setKeyResults(krTable);
            return Mono.just(okrTable);
        });
    }

    public static List<KrTable> generatekrTable(Flux<Kr> krs){
        List<KrTable> krTable = new ArrayList<>();
        krs.subscribe(kr -> krTable.add(new KrTable(kr.getKeyResult(), kr.getPersonInChargeNameKr(), kr.getAdvanceKr())));
        return krTable;
    }
}
