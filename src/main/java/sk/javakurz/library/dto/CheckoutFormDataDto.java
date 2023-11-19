package sk.javakurz.library.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutFormDataDto {
        private Long id;

        @NotNull
        @FutureOrPresent(message = "Dátum výpožičky nemôže byť v minulosti.")
        private Date startDate;

        private Date endDate;

        private boolean isReturned;

        @NotNull(message = "Kniha musí byť vybraná!")
        private Long bookId;

        @NotNull(message = "Čitateľ musí byť vybraný!")
        private Long patronId;
}
