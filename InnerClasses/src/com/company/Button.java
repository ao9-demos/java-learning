package com.company;

public class Button {
    private String title;
    private OnClickListner onClickListner;

    public Button(String title) {
        this.title = title;
    }

    public void setOnClickListner(OnClickListner onClickListner) {
        this.onClickListner = onClickListner;
    }

    public String getTitle() {
        return title;
    }

    public void onClick(){
        this.onClickListner.onClick(this.title);
    }

    public interface OnClickListner {
        void onClick(String title);

    }
}
