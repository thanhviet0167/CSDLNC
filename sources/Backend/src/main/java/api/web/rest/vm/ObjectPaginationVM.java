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
    private Integer totalCount;

    private Integer size;

    @JsonProperty("first_page")
    private Integer firstPage;

    @JsonProperty("last_page")
    private Integer lastPage;

    @JsonProperty("previous_page")
    private Integer previousPage;

    @JsonProperty("current_page")
    private Integer currentPage;

    @JsonProperty("next_page")
    private Integer nextPage;

    @JsonProperty("content_list")
    List contentList;

    public ObjectPaginationVM(Page page) {
        if (page == null) {
            return;
        }

        this.totalCount = (int) page.getTotalElements();
        this.size = page.getSize();

        this.firstPage = 0;
        this.lastPage = page.getTotalPages() >= 1 ? page.getTotalPages() - 1 : 0;

        this.currentPage = page.getNumber();
        this.previousPage = this.currentPage > 0 ? this.currentPage - 1 : 0;
        this.nextPage = this.currentPage + 1 < this.lastPage ? this.currentPage + 1 : (this.lastPage > 0 ? this.lastPage : 0);

        contentList = page.getContent();
    }

    public ObjectPaginationVM(List contentList, Integer pageNumber, Integer pageSize, Integer totalCount, Integer totalPage) {
        this.totalCount = totalCount;
        this.size = pageSize;

        this.firstPage = 0;
        this.lastPage = totalPage >= 1 ? totalPage - 1 : 0;

        this.currentPage = pageNumber;
        this.previousPage = this.currentPage > 0 ? this.currentPage - 1 : 0;
        this.nextPage = this.currentPage + 1 <= this.lastPage ? this.currentPage + 1 : (this.lastPage > 0 ? this.lastPage : 0);

        this.contentList = contentList;
    }
}
