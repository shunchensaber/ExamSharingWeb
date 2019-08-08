package me.hades.Constant;

public enum StateEnum {
    /**
     *状态信息
     */
    wait("待审核"),
    pass("审核通过");

    private String state;

    StateEnum(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
