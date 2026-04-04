FROM apache/spark:3.5.3-python3

USER root

# Install Python dependencies
RUN pip3 install --no-cache-dir pyspark==3.5.3

RUN mkdir -p /opt/spark/work-dir/jobs && chmod 755 /opt/spark/work-dir/jobs

# Copy all pyspark jobs
COPY *.py /opt/spark/work-dir/jobs/

# Fix permissions
RUN chmod -R 755 /opt/spark/work-dir/jobs

USER spark

WORKDIR /opt/spark/work-dir/jobs