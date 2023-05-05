# Entity Relationship Diagrams

```mermaid
erDiagram
  sequencing_instrument_illumina {
    int id PK
    string instrument_id
    string type
    string model
    timestamp timestamp_status_updated
    string current_sequencing_run_id
    string previous_sequencing_run_id
  }
  
  sequencing_instrument_nanopore {
    int id PK
    string instrument_id
    string type
    string model
    timestamp timestamp_status_updated
    string current_sequencing_run_id
    string previous_sequencing_run_id
  }
  
  sequencing_run_illumina {
    int id PK
    string sequencing_run_id
    string instrument_id
    string flowcell_id
    date run_date
    string experiment_name
    int num_cycles_r1
    int num_cycles_r2
    int cluster_count
    float percent_clusters_passed_filter
    float error_rate
    float first_cycle_intensity
    float percent_aligned
    float q30_percent
    float projected_yield_gigabases
    float yield_gigabases
    int num_reads
    int num_reads_passed_filter
    float percent_occupied
  }
  
  sequencing_run_illumina_demultiplexing {
    int id PK
    string demultiplexing_id
    string samplesheet_path
  }
  
  sequenced_library_illumina {
    int id PK
    string library_id
    string samplesheet_project_id
    string translated_project_id
    string index
    string index2
    int num_reads
    string fastq_path_r1
    string fastq_path_r2
  }
  
  sequencing_run_nanopore {
    int id PK
    string sequencing_run_id
    string instrument_id
    string samplesheet_path
    string flowcell_id
    string flowcell_product_code
    date run_date
    string protocol_id
    string protocol_run_id
    timestamp timestamp_protocol_run_started
    timestamp timestamp_protocol_run_ended
    int num_reads_total
    int num_reads_passed_filter
    float yield_gigabases
  }
  
  acquisition_run_nanopore {
    int id PK
    string acquisition_run_id
    int num_reads_total
    int num_reads_passed_filter
    int num_bases_total
    int num_bases_passed_filter
    string startup_state
    string state
    string finishing_state
    string stop_reason
    string purpose
    string basecalling_config_filename
    float events_to_base_ratio
    int sample_rate
    int channel_count
  }
  
  sequenced_library_nanopore {
    id int PK
    string library_id
    string samplesheet_project_id
    string translated_project_id
    string barcode_name
    string barcode_alias
    int num_reads
    string fastq_combined_path
  }
  
  sequencing_run_illumina ||--o{ sequencing_run_illumina_demultiplexing : demultiplexings
  sequencing_run_illumina_demultiplexing ||--o{ sequenced_library_illumina : libraries
  
  sequencing_run_nanopore ||--o{ acquisition_run_nanopore : acquisition_runs
  sequencing_run_nanopore ||--o{ sequenced_library_nanopore : libraries
```
