- pstack
```
显示每个进程的栈跟踪
```
- pstree
```
树结构显示进程
```
- jstack
```
jstack需要在java进程启动用户下运行，否则提示：
35606: Unable to open socket file: target process not responding or HotSpot VM not loaded
The -F option can be used when the target process is not respondin
```
- docker国内镜像
```
https://i16tmfo8.mirror.aliyuncs.com
sudo mkdir -p /etc/docker
sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://i16tmfo8.mirror.aliyuncs.com"]
}
EOF
sudo systemctl daemon-reload
sudo systemctl restart docker   
```
- docker查看所有后台容器
```
docker build -t nginx:v3 .
docker run --name web2 -d -p81:80 nginx:v3
docker ps -a -q 
#exec是进入已经存在的容器，run是创建新容器
docker exec -it ${ID/容器名称} /bin/bash
docker stop containerId
docker stop $(docker ps -a -q) //  stop停止所有容器
docker  rm $(docker ps -a -q) //   remove删除所有容器
```
- 配置静态ip
```
1.通过ifconfig查询网卡和IP
enp0s8: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500
        inet 192.168.56.101  netmask 255.255.255.0  broadcast 192.168.56.255
        inet6 fe80::88e4:449d:7a3a:8ad5  prefixlen 64  scopeid 0x20<link>
        ether 08:00:27:83:3a:35  txqueuelen 1000  (Ethernet)
        RX packets 35935  bytes 2733103 (2.6 MiB)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 34824  bytes 2220403 (2.1 MiB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
2.cd /etc/sysconfig/network-scripts/
3.vim ifcfg-enp0s8
TYPE=Ethernet
PROXY_METHOD=none
BROWSER_ONLY=no
BOOTPROTO=static
DEFROUTE=yes
IPV4_FAILURE_FATAL=no
IPV6INIT=yes
IPV6_AUTOCONF=yes
IPV6_DEFROUTE=yes
IPV6_FAILURE_FATAL=no
IPV6_ADDR_GEN_MODE=stable-privacy
NAME=enp0s3
UUID=1cb0cc6d-c666-4cd5-b310-50c69be319ef
DEVICE=enp0s8
ONBOOT=yes
IPADDR=192.168.56.101
NETMASK=255.255.255.0
GATEWAY=192.168.56.1
```