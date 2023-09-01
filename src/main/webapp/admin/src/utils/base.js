const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmne3m1/",
            name: "ssmne3m1",
            // 退出到首页链接
            indexUrl: 'http://localhost:63342/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "民宿预定系统"
        }
    }
}
export default base
