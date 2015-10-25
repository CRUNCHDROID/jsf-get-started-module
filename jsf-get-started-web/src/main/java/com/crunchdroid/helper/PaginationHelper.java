package com.crunchdroid.helper;

import javax.faces.model.DataModel;

/**
 *
 * @author Riad YOUSFI
 */
public abstract class PaginationHelper {

    private final int pageSize;
    private int nbPage;
    private int page;

    public PaginationHelper(int pageSize) {
        this.pageSize = pageSize;
    }

    public abstract int getItemsCount();

    public abstract DataModel createPageDataModel();

    public int getFirstItem() {
        return page * pageSize;
    }

    public int getLastItem() {
        int i = getFirstItem() + pageSize - 1;
        int count = getItemsCount() - 1;
        if (i > count) {
            i = count;
        }
        if (i < 0) {
            i = 0;
        }
        return i;
    }

    public int getNbPage() {
        nbPage = (int) Math.ceil(Double.valueOf(getItemsCount()) / Double.valueOf(pageSize));
        System.out.println("Math.ceil ::: " +  Math.ceil(Double.valueOf(getItemsCount()) / Double.valueOf(pageSize)));
        System.out.println("getItemsCount ::: " + getItemsCount());
        System.out.println("getNbPage ::: " + nbPage);
        return nbPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public boolean isHasPreviousPage() {
        return page > 0;
    }

    public void previousPage() {
        if (isHasPreviousPage()) {
            page--;
        }
    }

    public boolean isHasNextPage() {
        return page < nbPage-1;
    }

    public void nextPage() {
        if (isHasNextPage()) {
            page++;
        }
    }

    public int getPage() {
        return page;
    }

    public void goPage(int page) {
        this.page = page;
    }

}
