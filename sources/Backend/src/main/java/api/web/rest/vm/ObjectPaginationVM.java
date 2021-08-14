package api.web.rest.vm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ObjectPaginationVM implements Serializable {

    @JsonProperty("total_count")
    private Long totalCount;

    private Integer size;

    @JsonProperty("first_page")
    private Long firstPage;

    @JsonProperty("last_page")
    private Long lastPage;

    @JsonProperty("previous_page")
    private Long previousPage;

    @JsonProperty("current_page")
    private Long currentPage;

    @JsonProperty("next_page")
    private Long nextPage;

    @JsonProperty("content_list")
    List contentList;

    public ObjectPaginationVM(Page page) {
        if (page == null) {
            return;
        }

        this.totalCount = page.getTotalElements();
        this.size = page.getSize();

        this.firstPage = 1L;
        this.lastPage = page.getTotalPages() > 1L ? page.getTotalPages() : 1L;

        this.currentPage = (long) (page.getNumber() + 1);
        this.previousPage = this.currentPage > 1L ? this.currentPage - 1L : 1L;
        this.nextPage = this.currentPage + 1 < this.lastPage ? this.currentPage + 1L : this.lastPage;

        contentList = page.getContent();
    }
}
